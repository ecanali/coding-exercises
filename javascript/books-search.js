// Searching and counting data from arrays
// Given the following array, do:

const booksByCategory = [
    {
        category: "Riqueza",
        books: [
            {
                title: "Os segredos da mente milionária",
                author: "T. Harv Eker"
            },
            {
                title: "O homem mais rico da Babilônia",
                author: "George S. Clason"
            },
            {
                title: "Pai rico, pai pobre",
                author: "Robert T. Kiyosaki e Sharon L. Lechter"
            }
        ]
    },
    {
        category: "Inteligência Emocional",
        books: [
            {
                title: "Você é insubstituível",
                author: "Augusto Cury"
            },
            {
                title: "Ansiedade - como enfrentar o mal do século",
                author: "Augusto Cury"
            },
            {
                title: "Os 7 hábitos das pessoas altamente eficazes",
                author: "Stephen R. Covey"
            }
        ]
    }
]

// Count the number of categories and the number of books within each category
const totalCategories = booksByCategory.length
console.log(`O número de categorias é ${totalCategories}.`)

for (let category of booksByCategory) {
    console.log(`O número de livros dentro da categoria ${category.category} é ${category.books.length}`)
}

// Count the total number of authors
function countAuthors() {
    let authors = []

    for(let category of booksByCategory) {
        for(let book of category.books) {
            if(authors.indexOf(book.author) == -1) { // which means 'there is no author with this name in the "authors array" yet'.
                authors.push(book.author)
            }
        }
    }

    console.log("Total de autores: ", authors.length)
}

countAuthors()

// By each category version:
for (let element of booksByCategory) {
    const seen = new Set()
    const filteredArray = element.books.filter(element => {
        const duplicate = seen.has(element.author)
        seen.add(element.author)
        return !duplicate
    })

    console.log(`O número de autores dentro da categoria ${element.category} é ${filteredArray.length}`)
}

// Search only books of Augusto Cury:
function booksOfAugustoCury() {
    let books = []

    for(let category of booksByCategory) {
        for(let book of category.books) {
            if(book.author === "Augusto Cury") {
                books.push(book.title)
            }
        }
    }

    console.log("Livros de Augusto Cury: ", books)
}

booksOfAugustoCury()

// Create a function that will search for books of an author dynamically 
function booksByAuthor(author) {
    let books = []

    for(let category of booksByCategory) {
        for(let book of category.books) {
            if(book.author.includes(author)) {
                books.push(book.title)
            }
        }
    }

    console.log(`Livros de ${author}: `, books)
}

booksByAuthor("Robert")
booksByAuthor("Cury")