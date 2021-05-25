# Crie um programa que imprime os números primos entre 0 e 200, imprimindo ao final a soma destes números.
numero = 0
limite = 200
somaPrimos = 0

while numero <= limite:
  contador = 2
  isPrimo = True
  if numero == 0 or numero == 1:
    isPrimo = False
  else:
    while contador < numero:
      if numero % contador == 0:
        isPrimo = False
        break
      contador += 1

  if isPrimo:
    print(numero, "É primo!")
    somaPrimos += numero

  numero += 1

print('Soma de todos os primos =', somaPrimos)