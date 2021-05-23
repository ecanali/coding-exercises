joioETrigo = ["joio", "trigo", "trigo", "joio", "trigo", "joio", "joio", "joio", "joio", "trigo", "trigo", "joio", "joio", "joio", "trigo", "trigo", "trigo", "trigo", "trigo", "trigo", "trigo", "trigo", "trigo", "trigo", "trigo", "joio", "joio", "joio", "joio", "joio", "joio", "joio", "joio", "trigo", "trigo", "joio", "joio", "joio", "joio", "joio", "joio", "joio", "joio", "joio", "joio", "joio", "joio", "joio", "joio", "joio", "joio", "trigo", "trigo", "trigo", "trigo", "trigo", "trigo", "trigo", "trigo", "trigo", "trigo", "trigo", "trigo", "trigo", "trigo", "trigo", "trigo", "trigo", "trigo", "joio", "joio", "joio", "joio", "joio", "joio", "joio", "joio", "joio", "joio", "trigo", "trigo", "trigo", "trigo", "trigo", "trigo", "trigo", "trigo", "trigo", "joio", "joio", "joio", "joio", "joio", "joio", "trigo", "joio", "joio", "joio", "joio", "joio", "trigo", "trigo", "trigo", "trigo", "joio", "joio", "joio", "joio", "joio", "joio", "joio", "trigo", "trigo", "trigo", "joio", "trigo", "joio", "joio", "joio"]

joio = []
trigo = []

for item in joioETrigo:
  if item == 'joio':
    joio.append(item)
  elif item == 'trigo':
    trigo.append(item)

quantItems = len(joioETrigo)
quantJoios = len(joio)
quantTrigos = len(trigo)

print('"joioETrigo" tem,', quantItems, 'items')
print('Joios =', quantJoios, joio)
print('Trigos =', quantTrigos, trigo)