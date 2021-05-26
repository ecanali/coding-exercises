def imprimeValor(valor):
  print(valor)

def somaValores(valor1, valor2):
  print(valor1 + valor2)

def isDivisivel(val1, val2):
  if val1 % val2 == 0:
    return True
  else:
    return False

def maiorValor(valor1, valor2, valor3):
  if valor1 > valor2 and valor1 > valor3:
    return valor1
  elif valor2 > valor1 and valor2 > valor3:
    return valor2
  else:
    return valor3

def somaNumerosAte(valor):
  if valor >= 0:
    contador = 0
    soma = 0
    while contador < valor:
      soma += contador
      contador += 1
    return soma
  else:
    return -1
  
def quantidadeLetras(texto):
  return len(texto)

def imprimirLista(lista):
  for elemento in lista:
    print(elemento)

def menorTexto(listaTextos):
  menorQuantidadeCaracteresEncontrada = 100
  menorTexto = ''
  for texto in listaTextos:
    if len(texto) < menorQuantidadeCaracteresEncontrada:
      menorQuantidadeCaracteresEncontrada = len(texto)
      menorTexto = texto
  return menorTexto

def imprimeTantasVezesEsseTexto(numVezes, texto):
  contador = 0
  while contador < numVezes:
    print(texto)
    contador += 1

imprimeValor('oi')
somaValores(6, 4)
print(isDivisivel(4, 2))
print(isDivisivel(3, 2))
print(maiorValor(1, 2, 3))
print(maiorValor(6, 5, 4))
print(maiorValor(7, 9, 8))
print(somaNumerosAte(5))
print(somaNumerosAte(-10))
print(quantidadeLetras('Bruna'))
imprimirLista(['oi', 7, True])
print(menorTexto(['oie', 'tchau', 'oi', 'byebye']))
imprimeTantasVezesEsseTexto(3, "Kkkkk")
