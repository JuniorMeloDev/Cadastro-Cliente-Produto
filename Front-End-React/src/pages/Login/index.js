import { useForm } from "react-hook-form";
import { NavLink } from "react-router-dom";
import { yupResolver } from '@hookform/resolvers/yup';
import * as yup from "yup";
import './style.css';


const schema = yup.object().shape({                 //validação dos campos
    
    email: yup.string().email("Digite um email válido").required("O email é obrigatório"),
    password: yup.string().min(6, "A senha deve ter no mínimo 6 caracteres").required("A senha é obrigatória"), 
  }).required();



export const Login = () =>  {

    const { register, handleSubmit, formState: { errors } } = useForm({
        resolver: yupResolver(schema)
    })
  

    function onSubmit(userData) {
        console.log(userData)

        console.log(errors)
    }

    return (
        <div className="caixa">
            <form className="login-form" onSubmit={handleSubmit(onSubmit)}>
                <span className="login-form-title">Bem Vindo</span>
                    
                <div className="wrap-input">
                    Email:
                    <input className="inputUser" type="text" {...register("email", { required: true })} />
                    <span className="erro">{errors.email?.message}</span>
                </div>

                <div className="wrap-input">
                    Senha:
                    <input className="inputUser" type="password" {...register("password", { required: true })} />
                    <span className="erro">{errors.password?.message}</span>
                </div>

                <div className="container-login-form-btn">
                <button type="submit" className="btn btn-primary">Login</button>
                </div>
                
                <div className="text-center">
          <span className="txt1">Não possui conta? </span>
          <NavLink to='/register'>Criar Conta</NavLink>
       
          </div>
            </form>
        </div>
    )
}

