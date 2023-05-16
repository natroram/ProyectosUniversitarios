import ply.lex as lexico
import ply.yacc as sintactico

reservadas = {
  "select":"SELECT",
  "from":"FROM",
  "where":"WHERE",
  "top":"TOP",
  "and":"AND",
  "or":"OR"
  }
#Solo defina los tokens requeridos para sus queries
tokens = ("MAYOR", "MENOR", "IGUAL", "ENTERO", "DECIMAL", "ASTERISCO", "CADENA", "VARIABLE", "COMA") + tuple(reservadas.values() )

#Definir expresiones regulares
t_MAYOR = r'>'
t_MENOR = r'<'
t_IGUAL = r'='
t_ENTERO = r'([0-9]|[1-9][0-9]+)'
t_DECIMAL = r'(-\d+\.\d+|\d+\.\d+)'
t_ASTERISCO = r'\*'
t_CADENA = r'\"[a-zA-Z]+\"'
t_COMA = r','

def t_variable(t):
  r'[a-z]+'
  t.type = reservadas.get(t.value, "VARIABLE")
  return t
  
def t_countLines(t):
  r'\n+'
  t.lexer.lineno += t.value.count("\n")

def t_comentario(t):
  r'(\-\-.*|\s+)'
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

codigo = open("queries.sql")
for linea in codigo:
  validador.input(linea)
  getTokens(validador)
codigo.close()

#Aquí definir sus reglas sintácticas
#Solo defina las reglas que validen la sintaxis de sus queries
def p_expression_seleccion(p):
  '''
  expression : SELECT propiedades FROM VARIABLE
  '''
def p_expression_propiedades(p):
  '''
  propiedades : VARIABLE | propiedades COMA propiedades
  '''
def p_sentencia(p):
  'sentencia : expression'

def p_consultas(p):
  'consultas : MENOR MAYOR'

#Imprime errores según las reglas
def p_error(p):
  if p:
    print("Error de sintaxis en token", p.type)
  else:
    print("Error de sintaxis EOF")

# Construye el parser
parser = sintactico.yacc()

linea=" "
codigo = open("queries.sql")
result = parser.parse(codigo.read())
codigo.close()

print("Lección terminada :)")