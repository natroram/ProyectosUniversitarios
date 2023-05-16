import ply.lex as lexico
import ply.yacc as sintactico

#Solo defina los tokens requeridos para sus queries
tokens = ("PAR_I", "PAR_D", "SUMA", "MULTIPLICACION", "MODULO", "ENTERO",
          "VARIABLE", "IGUAL", "DEF", "PRINT", "RETURN", "COMA", "DOS_PUNTOS")

#Definir expresiones regulares
t_PAR_I = r'\('
t_PAR_D = r'\)'
t_SUMA = r'\+'
t_MULTIPLICACION = r'\*'
t_MODULO = r'\%'
t_ENTERO = r'(0|[1-9]+[0-9]*)'
t_VARIABLE = r'[a-z_]+[0-9]*[a-z]*'
t_IGUAL = r'='
t_DEF = r'def'
t_PRINT = r'print'
t_RETURN = r'return'
t_COMA = r','
t_DOS_PUNTOS = r':'


def t_countLines(t):
    r'\n+'
    t.lexer.lineno += t.value.count("\n")


def t_comentario(t):
    r'\#.*'
    pass


def t_espacio(t):
    r'\s+'
    pass


def t_error(t):
    print(f"Caracter no reconocido {t.value[0]} en línea {t.lineno}")
    t.lexer.skip(1)


validador = lexico.lex()


def getTokens(lexer):
    while True:
        tok = lexer.token()
        if not tok:
            break
        print(tok)


codigo = open("subprogramas.py")
for linea in codigo:
    validador.input(linea)
    getTokens(validador)
codigo.close()


#Aquí definir sus reglas sintácticas
#Solo defina las reglas que validen la sintaxis de sus queries
def p_sentencias(p):
  '''
  sentencia : funcion
  '''


def p_valor(p):
  '''
  valor : ENTERO
        | VARIABLE
  '''


def p_operador(p):
  '''
  operador : SUMA
           | MULTIPLICACION
           | MODULO
  '''


def p_expresion(p):
  '''
  expresion : valor operador valor
  '''


def p_asignacion(p):
  '''
  asignacion : VARIABLE IGUAL valor
             | VARIABLE IGUAL expresion
  '''


def p_parametros(p):
  '''
  parametros : parametros COMA VARIABLE
             | parametros COMA asignacion
             | MULTIPLICACION VARIABLE
  '''


def p_llamar_funcion(p):
  '''
  llamar_funcion : VARIABLE PAR_I parametros PAR_D
  '''


def p_terminal_funcion(p):
  '''
  terminal : PRINT
           | RETURN
  '''


def p_final_funcion(p):
  '''
  final : terminal llamar_funcion
        | terminal expresion
  '''


def p_funcion(p):
    'funcion : DEF llamar_funcion DOS_PUNTOS expresion final'


#Imprime errores según las reglas
def p_error(p):
    if p:
        print("Error de sintaxis en token", p.type)
    else:
        print("Error de sintaxis EOF")


# Construye el parser
parser = sintactico.yacc()

linea = " "
codigo = open("subprogramas.py")
result = parser.parse(codigo.read())
codigo.close()

print("Examen terminado :)")
