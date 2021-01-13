// Create a function that will calculate the balance from a given family cash flow, then show the results

const familyCashFlow = {
    incomes: [1100, 500, 200, 100, 100],
    expenses: [250, 550, 100, 50, 550]
}

// Separates the sum function from the main function
function sumEntries(entriesArray) {
    let total = 0

    for (let entry of entriesArray) {
        total += entry
    }

    return total
}

function calculateBalance(cashFlow) {
    const totalIncomes = sumEntries(cashFlow.incomes)

    const totalExpenses = sumEntries(cashFlow.expenses)

    const finalBalance = totalIncomes - totalExpenses

    const positiveBalance = finalBalance >= 0

    let message = "NEGATIVE"

    if (positiveBalance) {
        message = "POSITIVE"
    }

    console.log(`The family's cash flow is ${message}, the balance is ${finalBalance}.`)
}

calculateBalance(familyCashFlow)