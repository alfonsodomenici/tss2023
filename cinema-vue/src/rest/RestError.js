export default class RestError extends Error{
    constructor(msg,statusText,statusCode){
        super(msg);
        this.statusText=statusText;
        this.statusCode = statusCode;
    }
    toString() {
        return `msg:${this.message} , response code:${this.statusCode} , response text:${this.statusText} , `;
    }
}