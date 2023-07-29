import { createStore } from 'redux'

function loginReducer(state, action){
    switch(action.type){
        case 'login/setToken':
            return {...state, token: action.tokenValue}
        case 'default':
            return state
        default:
            return state    
    }
}

let loginStore=createStore(loginReducer);

export default loginStore
