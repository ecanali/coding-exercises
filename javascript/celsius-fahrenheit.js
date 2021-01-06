// Create a function that receives a string in Celsius or Fahrenheit and transforms it from one unit to other

function convertCelsiusAndFahrenheit(temperature) {
    const celsiusExists = temperature.toUpperCase().includes("C")
    const fahrenheitExists = temperature.toUpperCase().includes("F")
    
    let arrayImputed = String(temperature).split("")
    arrayImputed.splice(arrayImputed.length - 1)
    let temperatureInRawNumber = Number(arrayImputed.join(""))

    let convertedTemperature = 0
    let messageImputedValue = "Fahrenheit"
    let messageConvertedValue = "Celsius"

    if(celsiusExists) {
        convertedTemperature = (temperatureInRawNumber * 9) / 5 + 32
        messageImputedValue = "Celsius"
        messageConvertedValue = "Fahrenheit"
    } else if (fahrenheitExists) {
        convertedTemperature = (temperatureInRawNumber - 32) * 5 / 9
    } else {
        throw new Error("Unidentified temperature")
    }

    return console.log(`${temperatureInRawNumber} graus ${messageImputedValue} equivalem a ${convertedTemperature.toFixed(2)} graus ${messageConvertedValue}.`)
}

try {
    convertCelsiusAndFahrenheit("90F")
    convertCelsiusAndFahrenheit("32.22C")
    convertCelsiusAndFahrenheit("39c")
    convertCelsiusAndFahrenheit("75.86F")
    convertCelsiusAndFahrenheit("90z")
} catch (error) {
    console.log(error.message)
}