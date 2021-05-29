print('Digite um número inteiro e descubra se ele é perfeito ou não (negativo para sair)')

programaAtivo = True

while programaAtivo:
  numeroInformado = int(input('Digite um número inteiro: '))

  if numeroInformado > 0:
    somaDivisores = 0

    divisor = 1
    while divisor < numeroInformado:
      if numeroInformado % divisor == 0:
        somaDivisores += divisor
        divisor += 1
      else:
        divisor += 1

    if somaDivisores == numeroInformado:
      print('O número inteiro', numeroInformado, 'É perfeito.')
    else:
      print('O número inteiro', numeroInformado, 'NÃO é perfeito.')

  else:
    programaAtivo = False

print('Programa finalizado.')
