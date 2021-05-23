# Criar um programa que informa uma série de opções para o usuário. De acordo com o que o usuário digitar, uma ação diferente será tomada.
print('Olá Fulano.\nDigite a opção desejada:\n1) Verificar triângulo\n2) Calcular equação do segundo grau\n3) Conferir data\n4) Verificar tamanho do texto\n5) Analisar CPF\n6) Contar caracteres\n7) Sair')

opcaoInformada = input("Digite sua opção: ")

if opcaoInformada == '1':
  print('Opção informada 1) Verificar triângulo')

  lado1 = int(input('Informe o valor inteiro do Lado 1: '))
  lado2 = int(input('Informe o valor inteiro do Lado 2: '))
  lado3 = int(input('Informe o valor inteiro do Lado 3: '))

  isTrianguloTeste1 = ((abs(lado2) - abs(lado3)) < lado1) < (lado2 + lado3)
  isTrianguloTeste2 = ((abs(lado1) - abs(lado3)) < lado2) < (lado1 + lado2)
  isTrianguloTeste3 = ((abs(lado1) - abs(lado2)) < lado3) < (lado1 + lado2)
  
  if isTrianguloTeste1 and isTrianguloTeste2 and isTrianguloTeste3:
    tipoTriangulo = ''
    if lado1 == lado2 and lado2 == lado3:
      tipoTriangulo = 'Equilátero'
    elif lado1 == lado2 or lado2 == lado3 or lado3 == lado1:
      tipoTriangulo = 'Isósceles'
    else:
      tipoTriangulo = 'Escaleno'
    print('Os lados informados formam um Triângulo', tipoTriangulo)
  else:
    print('Os lados informados não formam um triângulo')

elif opcaoInformada == '2':
  print('Opção informada 2) Calcular equação do segundo grau')

  a = int(input("Digite o valor de a: "))
  b = int(input("Digite o valor de b: "))
  c = int(input("Digite o valor de c: "))

  if a == 0:
    print('Erro: Valor de a não pode ser zero, não se trata de uma equação de segundo grau')
  else:
    # Cálculo da equação de segundo grau
    delta = (b ** 2) - (4 * (a * c))
    x1linha = ((- b) + (delta ** (1/2))) / (2 * a)
    x2linhas = ((- b) - (delta ** (1/2))) / (2 * a)

    if delta < 0:
      print('Erro: Valor calculado de delta não pode ser negativo (',delta,') a equação não possui raízes reais')
    elif delta == 0:
      print('Com delta igual a 0 a equação possui apenas 1 raiz real que é:', x1linha)
    else:
      print("As duas raízes são: x' =", x1linha, "e x'' =", x2linhas)

elif opcaoInformada == '3':
  print('Opção informada 3) Conferir data')

  dia = int(input("Digite o número do dia: "))
  mes = int(input("Digite o número do mês: "))
  ano = int(input("Digite o ano: "))

  meses31dias = [1, 3, 5, 7, 8, 10, 12]
  meses30dias = [4, 6, 9, 11]

  mensagemDeSucesso = 'A data informada de '+str(dia)+'/'+str(mes)+'/'+str(ano)+' está correta'
  mensagemDeInsucesso = 'A data informada de '+str(dia)+'/'+str(mes)+'/'+str(ano)+' está incorreta'

  if dia in range(1, 32) and mes in meses31dias and ano in range(1, 10000):
    print(mensagemDeSucesso)
  elif dia in range(1, 31) and mes in meses30dias and ano in range(1, 10000):
    print(mensagemDeSucesso)
  elif dia in range(1, 30) and mes == 2 and ano in range(1, 10000):
    print(mensagemDeSucesso)
  else:
    print(mensagemDeInsucesso)

elif opcaoInformada == '4':
  print('Opção informada 4) Verificar tamanho do texto')

  texto = input('Digite um texto: ')

  if len(texto) < 5:
    print('O texto é muito pequeno, tem', len(texto),'caracteres')
  elif len(texto) >= 5 and len(texto) < 15:
    print('O texto é de tamanho médio, tem', len(texto),'caracteres')
  elif len(texto) >= 15 and len(texto) < 20:
    print('O texto é de tamanho grande, tem', len(texto),'caracteres')
  else:
    print('O texto é inválido')

elif opcaoInformada == '5':
  print('Opção informada 5) Analisar CPF')

  cpf = input('Informe o seu CPF (apenas números): ')

  if cpf.isdigit() and len(cpf) == 11:
    print(cpf,'é um CPF válido')
  else:
    print(cpf,'é um CPF inválido')

elif opcaoInformada == '6':
  print('Opção informada 6) Contar caracteres')

  texto = input('Digite um texto: ')

  vogais = 0
  espacos = 0
  todasVogais = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U', 'á', 'Á', 'ã', 'Ã', 'à', 'À', 'â', 'Â', 'é', 'É', 'ê', 'Ê', 'í', 'Í', 'ú', 'Ú']

  for vogal in todasVogais:
    quantidade = texto.count(vogal)
    if quantidade > 0:
      vogais += quantidade
  
  if texto.count(' ') > 0:
    espacos = texto.count(' ')

  outrosCaracteres = (len(texto) - vogais) - espacos

  print('O texto possui',vogais,'vogais,',espacos,'espaços e',outrosCaracteres,'outros caracteres')

elif opcaoInformada == '7':
  print('Obrigado por utilizar nosso sistema.')

else:
  print('Erro: Opção inválida, programa finalizado')