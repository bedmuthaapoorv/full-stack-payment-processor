
//import './Login.css';

import { useState } from "react";
import axios from "axios";

	/*	
	 Response Codes

	1: login success
	2: login unsuccessful
	3: login success from cache
	
	*/

function Login() {
  let [username,setUsername]=useState("")
  let [password,setPassword]=useState("")
  let [ip,setIP]=useState("")

  function getIP(){
    return axios.get("https://geolocation-db.com/json/").then((response)=>{
      setIP(response.data.IPv4);
    })
  }

  function loginAction(responseCode){
    switch(responseCode){
      case 1:
        console.log("redirect to dashboard")
        break
      case 2:
        console.log("incorrect credentials try again")
        break
      case 3:
        console.log("redirect to dashboard")
        break
      default:
        console.log("unexpected response"+responseCode)
      }
  }

  function checkCredentials(event){

    //console.log(username+" "+password)
    const date=new Date()
    getIP().then((ipresponse) => {

      axios.post("http://127.0.0.1:8080/login", {
        "username": username,
        "password": password,
        "hours": date.getHours(),
        "minutes": date.getMinutes(),
        "ip": ip
      }, {
        headers: {
          'Content-Type': `application/json`
        }
      }).then((response) => {
        loginAction(response.data)
      })

    })

    
  }

  return (
    <div>
        <label>Username:</label>
        <input type="text" onChange={(event)=>setUsername(event.target.value)}></input>
        <br></br>
        <label>Password:</label>
        <input type="password" onChange={(event)=>setPassword(event.target.value)}></input>
        <br></br>
        <input type="submit" onClick={checkCredentials}></input>
      <br></br>
      Don't have an account? <a href="/createAccount"><button>create new account</button></a>
    </div>
  );
}

export default Login;
