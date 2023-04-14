export default class LoginView extends HTMLElement{
        
        constructor(){
            super();
            console.log('login construct...')
        }
        
        connectedCallback(){
            console.log('connected Callback....');
            this.render();
        }
        
        disconnectedCallback(){
            console.log('disconnected Callback....');
        }
        
        render(){
            this.innerHTML = `
                <form >
                    <input type="text" id="usr" placeholder="username" required autocomplete="off"  />
                    <input type="password" id="pwd" placeholder="password" required/>
                    <button id="cmdLogin" value="Login" >Login</button>
                </form>
            `;
        }
}

customElements.define("cinema-login", LoginView);