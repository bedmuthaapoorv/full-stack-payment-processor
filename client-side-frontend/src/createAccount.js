//import './App.css';
import { useState } from "react";
import axios from "axios";



function CreateAccount() {
  let [username,setUsername]=useState("")
  let [password,setPassword]=useState("")
  let [ip,setIP]=useState("")

  function AccountAction(responseCode){
    switch(responseCode){
      case 1:
        alert("Account created")
        break
      case 2:
        alert("username already exists")
        break
      default:
        alert("unexpected response"+responseCode)
      }
  }

  function getIP(){
    return axios.get("https://geolocation-db.com/json/").then((response)=>{
      setIP(response.data.IPv4);
    })
  }

  function AccountCreation(event){
    const date=new Date()
    getIP().then((ipresponse) => {
      axios.post("http://127.0.0.1:8080/createAccount", {
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
        AccountAction(response.data)
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
        <input type="submit" onClick={AccountCreation}></input>
        <br></br>
        Already have an account? <a href="/"><button>Login</button></a>
    </div>
  );
}

export default CreateAccount;
