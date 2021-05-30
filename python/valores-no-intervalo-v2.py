de0a100 = 0
de101a200 = 0
de201a400 = 0
maiorDe400 = 0

while True:
  numeroInformado = int(input('Digite um inteiro positivo (negativo para encerrar): '))

  if numeroInformado < 0:
    break
  elif numeroInformado <= 100:
    de0a100 += 1
  elif numeroInformado <= 200:
    de101a200 += 1
  elif numeroInformado <= 400:
    de201a400 += 1
  else:
    maiorDe400 += 1

print('Foram digitados', de0a100, 'números no intervalo de 0 a 100')
print('Foram digitados', de101a200, 'números no intervalo de 101 a 200')
print('Foram digitados', de201a400, 'números no intervalo de 201 a 400')
print('Foram digitados', maiorDe400, 'números no intervalo de 401 a ∞')