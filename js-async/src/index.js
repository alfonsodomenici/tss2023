
console.log('inizio script');
/*
fetch('https://jsonplaceholder.typicode.com/todos/1')
    .then(response => {
        console.log('arrivata la risposta da fetch...')
        const promise = response.json();
        console.log(promise);
        return promise;
    })
    .then(json => {
        console.log("arrivato il json dalla risposta...")
        console.log(json);
    }).catch(e => console.log(e))
    .finally(_ => {

    })

console.log('codice a seguire la fetch...')
*/

const sleep = async (ms) => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            if (ms <= 5000) {
                resolve(`Promise risolta dopo ${ms} millisecondi`);
            } else {
                reject('timeout troppo alto');
            }
        }, ms)
    })
}

sleep(6000)
    .then(result => {
        console.log('tutto ok', result);
    }).catch(result => {
        console.log('sleep non ok..', result);
    })