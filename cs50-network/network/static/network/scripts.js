document.addEventListener('DOMContentLoaded', function() {
    editLinks = document.querySelectorAll('.edit-post')
    for (let link of editLinks) {
        link.addEventListener('click', (event) => editPost(event));
    }
    // document.querySelector('#compose-form').addEventListener('submit', send_email);
});


// escutar click na anchor tag "Edit"
// chama funcao que esconde P Tag com o Content e Cria um TextArea com o conteúdo

function editPost(event) {
    event.preventDefault();

    // Hide original text
    postDiv = document.getElementById(`${event.target.dataset.post}`)
    pTag = postDiv.getElementsByTagName('p')[0]
    pTag.style.display = 'none';

    // Create a textarea with the original text inside
    const textArea = document.createElement('textarea')
    textArea.value = pTag.innerHTML
    textArea.className = 'form-control';
    pTag.parentNode.insertBefore(textArea, pTag.nextSibling);
}