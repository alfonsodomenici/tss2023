console.log('inizio richiesta fetch');

const request = async (url) => {
    const resp = await fetch(url);
    console.log('arrivata la risposta da fetch...');
    console.log(resp.ok ? 'risposta ok': 'risposta ko');
    return resp.json();
}

request('https://jsonplaceholder.typicode.com/todos/1')
    .then(json => {
        console.log("arrivato il json dalla risposta...")
        console.log(json);
    })

console.log('codice a seguire la fetch...')
