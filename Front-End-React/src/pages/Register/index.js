import { useForm } from "react-hook-form";
import React, { useState, useEffect } from 'react';
import { Link } from "react-router-dom";
import { yupResolver } from '@hookform/resolvers/yup';
import * as yup from "yup";
import { normalizePhoneNumber } from "../../components/mascaraTelefone/MascaraTelefone";
import './style.css';


const schema = yup.object().shape({                 //validação dos campos
    name: yup.string().required("O nome é obrigatório"),
    phone: yup.string().required("O telefone é obrigatório"),
    email: yup.string().email("Digite um email válido").required("O email é obrigatório"),
    password: yup.string().min(6, "A senha deve ter no mínimo 6 caracteres").required("A senha é obrigatória"),
    confirmPassword: yup.string().required("A confirmação da senha é obrigatória").oneOf([yup.ref("password", "As senhas devem ser iguais")]),
}).required();
 
export const Register = () => {

    const { register, handleSubmit, reset, watch, setValue, formState: { errors } } = useForm({
        resolver: yupResolver(schema)
    })

    const phoneValue = watch('phone')

    useEffect(() => {
        setValue('phone', normalizePhoneNumber(phoneValue))
    }, [phoneValue])    
        
    function onSubmit(userData) {
              console.log (userData)
    
    console.log(errors)
}

return (
    <div className="caixa-2">
        <form className="login-form" onSubmit={handleSubmit(onSubmit)}>
            <span className="login-form-title"> Criar Conta </span>

            <label>
                Nome:
                <input className="inputUser" type='text'{...register("name", { required: true })} />
                <span>{errors.name?.message}</span>
            </label>

            <label>
                Email:
                <input className="inputUser" type="text" {...register("email", { required: true })} />
                <span>{errors.email?.message}</span>
            </label>
            
            <label>
                Telefone:
                <input className="inputUser" {...register("phone", { required: true })} />
                <span>{errors.phone?.message}</span>
            </label>

            <label>
                Senha:
                <input className="inputUser" type="password" {...register("password", { required: true })} />
                <span>{errors.password?.message}</span>
            </label>

            <label>
                Confirmar Senha:
                <input className="inputUser" type="password" {...register("confirmPassword", { required: true })} />
                <span>{errors.confirmPassword?.message}</span>
            </label>

            <button type="submit" className="btn btn-primary">Cadastrar</button>
            <div className="text-center">

            <span className="txt1">Já possui conta? </span>
            <Link className="txt2" to="/login">
                    Acessar com Email e Senha.
             </Link>
            </div>
        </form>
    </div>
)
}
