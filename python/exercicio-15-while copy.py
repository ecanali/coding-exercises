# Crie um programa que imprime os números primos entre 0 e 200, imprimindo ao final a soma destes números.
numeroAvaliado = 0
limite = 200
somaPrimos = 0

while numeroAvaliado <= limite:
  contador = 2
  isPrimo = True
  if numeroAvaliado == 0 or numeroAvaliado == 1:
    isPrimo = False
  else:
    while contador < numeroAvaliado:
      if numeroAvaliado % contador == 0:
        isPrimo = False
        break
      contador += 1

  if isPrimo:
    print(numeroAvaliado, "É primo!")
    somaPrimos += numeroAvaliado

  numeroAvaliado += 1

print('Soma de todos os primos =', somaPrimos)