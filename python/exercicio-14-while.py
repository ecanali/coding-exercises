# Crie um programa que diga se o número informado pelo usuário é primo ou não.
numeroDigitado = int(input("Digite um número inteiro: "))
isPrimo = True
contador = 2
while contador < numeroDigitado:
  if numeroDigitado % contador == 0:
    isPrimo = False
    break
  contador += 1

if isPrimo:
  print("É primo!")
else:
  print("Não é primo!")