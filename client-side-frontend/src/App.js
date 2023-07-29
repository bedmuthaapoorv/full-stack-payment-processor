
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Login from './Login';
import CreateAccount from './createAccount'
import BankDashboard from './BankDashBoard';
function App() {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login></Login>}></Route>
          <Route path="/createAccount" element={<CreateAccount></CreateAccount>}></Route>
          <Route path="/bankDashboard" element={<BankDashboard></BankDashboard>}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
