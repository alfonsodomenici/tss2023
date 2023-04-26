console.log('inizio richiesta fetch');

const request = async (url) => {
    const resp = await fetch(url);
    console.log('arrivata la risposta da fetch...');
    console.log(resp.ok ? 'risposta ok' : 'risposta ko');
    return resp.json();
}

/*
La Promise verrà risolta dopo il timeout passato. 
Se il timeout è superiore a 5 sec la Promise viene rifiutata
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

/*
sleep(6000)
    .then(_ => {
        return request('https://jsonplaceholder.typicode.com/todos/1');
    }).then(json => {
        console.log(json);
    }).catch(e => {
        console.log('qualcosa è andato storto..')
        console.log(e);})
    .finally(_ => console.log('richiesta asincrona terminata'));
*/


//Promise composition

Promise.allSettled([request('https://jsonplaceholder.typicode.com/todos'),
request('https://jsonplaceholder.typicode.com/users'), sleep(6000)])
.then(([res1,res2,res3]) => {
    console.log('tutte le Promise sono state completate');
    console.log(res1);
    console.log(res2);
    console.log(res3);
}).catch(e => console.log(e));



/*
const promise1 = Promise.resolve(3);
const promise2 = new Promise((resolve, reject) => setTimeout(reject, 100, 'foo'));
const promises = [promise1, promise2];

Promise.allSettled(promises).
  then((results) => results.forEach((result) => console.log(result)));
  */