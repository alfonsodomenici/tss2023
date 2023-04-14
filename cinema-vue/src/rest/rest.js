import appConfig from "../app.config.js";
import RestError from "./RestError.js";

const postData = async(path = "", data = {}) => {
    
    const response = await fetch(`${appConfig.url}/${path}`, {
      method: "POST", 
      cache: "no-cache",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data), 
    });
    if(!response.ok){
      throw new RestError("error in postdata",response.statusText,response.status)
    }
    return response;
  }

  export {postData};