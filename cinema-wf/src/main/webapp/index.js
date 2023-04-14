import {postData} from './rest.js';
import LoginView from './LoginView.js'
console.log('script caricato...');

const usr = document.querySelector('#usr');
const pwd = document.querySelector('#pwd');
const btn = document.querySelector('#cmdLogin');
const form = document.querySelector('form');
const app = document.querySelector('#app');

const welcomeContent = (msg,token) => {
    const html = `
        <p>Benvenuto</p>
        <p>Hai effettuato la login con successo</p>
        <p>Il tuo messaggio è ${msg}</p>
        <p>${token}</p>
    `;
    return html;
}

const onLogin = (event) => {
    
    event.preventDefault();
    
    if(form.checkValidity() === false){
        form.reportValidity();
        return;
    }
    
    
    const credential = {
        usr: usr.value,
        pwd: pwd.value
    };
    
    postData('http://localhost:8080/cinema-wf-1.0/api/utenti/login',
        credential)
            .then(json => {
                app.innerHTML = welcomeContent(`Ciao ${usr.value}`,json.jwt)
    });
};


btn.addEventListener('click', onLogin);



