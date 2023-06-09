import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import { Login } from "../pages/Login";
import { Register } from "../pages/Register";
import { Cadastro } from "../pages/Cadastro";

//const Private = ({ Item }) => {
  //const signed = false // a tela de cadastro so entra com login
//}

export const AppRouter = () => {
  return (
    <Router>
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />   
        <Route exact path="/cadastro" element={< Cadastro />} />    
      </Routes>
    </Router>
  );
};
