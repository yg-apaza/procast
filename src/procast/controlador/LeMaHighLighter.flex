package procast.controlador;

import java.io.*;   
import javax.swing.text.Segment;   

import org.fife.ui.rsyntaxtextarea.*;   

%%   

%public   
%class LeMaTokenMaker   
%extends AbstractJFlexCTokenMaker   
%unicode   
%type org.fife.ui.rsyntaxtextarea.Token   

%{
    public LeMaTokenMaker()
    {   
    }   
 
    private void addHyperlinkToken(int start, int end, int tokenType)
    {   
        int so = start + offsetShift;   
        addToken(zzBuffer, start,end, tokenType, so, true);   
    }   

    private void addToken(int tokenType)
    {   
        addToken(zzStartRead, zzMarkedPos-1, tokenType);   
    }   
 
    private void addToken(int start, int end, int tokenType)
    {   
        int so = start + offsetShift;   
        addToken(zzBuffer, start,end, tokenType, so, false);   
    }   

    public void addToken(char[] array, int start, int end, int tokenType, int startOffset, boolean hyperlink)
    {   
        super.addToken(array, start,end, tokenType, startOffset, hyperlink);   
        zzStartRead = zzMarkedPos;   
    }   

    public Token getTokenList(Segment text, int initialTokenType, int startOffset)
    {
        resetTokenList();   
        this.offsetShift = -text.offset + startOffset;   
        
        int state = Token.NULL;
        switch (initialTokenType)
        {
            case Token.COMMENT_MULTILINE:
                state = MLC;
                start = text.offset;
                break;

            default:
                state = Token.NULL;
        }

        s = text;
        try
        {
           yyreset(zzReader);
           yybegin(state);
           return yylex();
        }
        catch (IOException ioe)
        {
           ioe.printStackTrace();
           return new Token();
        }
    }

    private boolean zzRefill()
    {
       return zzCurrentPos>=s.offset+s.count;
    }

    public final void yyreset(Reader reader)
    {
       zzBuffer = s.array;
       zzStartRead = s.offset;
       zzEndRead = zzStartRead + s.count - 1;
       zzCurrentPos = zzMarkedPos = zzPushbackPos = s.offset;
       zzLexicalState = YYINITIAL;
       zzReader = reader;
       zzAtBOL  = true;
       zzAtEOF  = false;
    }
%}

L = [a-zA-Z_]
H = [0-9A-F]
O = [0-8]
D = [0-9]
WHITE = [ \t\r\n]
MLCBegin               = "/*"   
MLCEnd               = "*/"  
%state MLC

%%   
<YYINITIAL>
{
    /* ESPACIOS EN BLANCO Y SALTOS DE LÍNEA */
    {WHITE}                                 {addToken(Token.WHITESPACE);}

    /* COMENTARIOS */
    {MLCBegin}                              {start = zzMarkedPos-2; yybegin(MLC);}   
    "//"[^\n]*                              {addToken(Token.COMMENT_EOL); addNullToken(); return firstToken;}
    
    /* CONSTANTES */
    "const"                                 {addToken(Token.DATA_TYPE);}

    /* TIPOS DE DATOS BASICOS */
    "vacio" | "entero" | "real" | "cadena"  {addToken(Token.DATA_TYPE);}

    /* OPERADORES DE AGRUPACIÓN */
    "(" | ")" | "{" | "}"                   {addToken(Token.SEPARATOR);}

    /* OPERADORES ARITMÉTICOS */
    "+" | "-" | "*" | "/" | "%" | "'" |
    "^" | "++" | "--"                       {addToken(Token.OPERATOR);}

    "suma" | "resta" | "producto" |
    "transpuesta" | "inversa"               {addToken(Token.FUNCTION);}
    
    /* OPERADORES DE RELACIÓN */
    "==" | "!=" | "<" | ">" | "<=" | ">="   {addToken(Token.OPERATOR);}

    /* OPERADORES LÓGICOS */
    "&&" | "||" | "!"                       {addToken(Token.OPERATOR);}

    /* OPERADORES DE ASIGNACIÓN */
    "=" | "+=" | "-=" | "*=" | "/=" | "%="  {addToken(Token.OPERATOR);}

    /* OPERADOR CONDICIONAL */
    "?" | ":"                               {addToken(Token.OPERATOR);}

    /* OPERADOR DE ACCESO A CAMPO */
    "[" | "]"                               {addToken(Token.SEPARATOR);}

    /* NÚMERO OCTAL ENTERO Y REAL */
    "0"{O}+                                 {addToken(Token.LITERAL_NUMBER_DECIMAL_INT);}
    "0"{O}+"."{O}+                          {addToken(Token.LITERAL_NUMBER_DECIMAL_INT);}

    /* NÚMERO HEXADECIMAL ENTERO Y REAL */
    "0x"{H}+                                {addToken(Token.LITERAL_NUMBER_DECIMAL_INT);}
    "0x"{H}+"."{H}+                         {addToken(Token.LITERAL_NUMBER_DECIMAL_INT);}

    /* NÚMERO SIMPLE ENTERO Y REAL*/
    {D}+                                    {addToken(Token.LITERAL_NUMBER_DECIMAL_INT);}
    {D}+"."{D}+                             {addToken(Token.LITERAL_NUMBER_DECIMAL_INT);}

    /* CADENAS */
    \"[^\"\n]*\"                            {addToken(Token.LITERAL_STRING_DOUBLE_QUOTE);}

    /* INSTRUCCIONES DE ENTRADA Y SALIDA */
    "leer" | "mostrar"                      {addToken(Token.FUNCTION);}

    /* SEPARADORES */
    ";" | ","                               {addToken(Token.IDENTIFIER);}

    /* FUNCIONES */
    "retornar"                              {addToken(Token.RESERVED_WORD);}

    /* SENTENCIAS CONDICIONALES */
    "si" | "sino"                           {addToken(Token.RESERVED_WORD);}

    /* SENTENCIAS DE REPETICIÓN */
    "mientras" | "hacer" | "para"           {addToken(Token.RESERVED_WORD);}


    /* SENTENCIAS DE SELECCIÓN MÚLTIPLE */
    "selector" | "saltar" | "caso" |
    "pordefecto"                            {addToken(Token.RESERVED_WORD);}


    /* MENÚ PRINCIPAL */
    "principal"                             {addToken(Token.RESERVED_WORD);}

    /* IDENTIFICADOR */
    {L}+({L}|{D})*                          {addToken(Token.IDENTIFIER);}

    \n |   
    <<EOF>>                                 {addNullToken(); return firstToken;}

    /* ERROR */
    .                                       {addToken(Token.ERROR_IDENTIFIER);}
}

<MLC>
{   
    [^\n*]+                                 {}   
    {MLCEnd}                                {yybegin(YYINITIAL);
                                             addToken(start,zzStartRead+2-1, Token.COMMENT_MULTILINE);}   
    "*"                                     {}   
    \n |
    <<EOF>>                                 {addToken(start,zzStartRead-1, Token.COMMENT_MULTILINE);
                                             return firstToken;}   
}   