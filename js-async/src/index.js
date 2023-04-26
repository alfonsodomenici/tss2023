console.log('inizio richiesta fetch');

fetch('https://jsonplaceholder.typicode.com/todos/1')
    .then(response => {
        console.log('arrivata la risposta da fetch...')
        return response.json();})
    .then(json => {
        console.log("arrivato il json dalla risposta...")
        console.log(json);
    })

console.log('codice a seguire la fetch...')
