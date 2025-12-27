import '../assets/style/registration.css'
import { Link } from 'react-router-dom'
import {addUser} from "../service/RegistrationService"
import { useState } from 'react'


export const RegistrationPage = () => {
    const [user_name, setUserName]=useState('')
    const [email, setEmail]=useState('')
    const [password, setpassword]=useState('')
    const [confirm_password, setConformPass]=useState('')
// Validation utility function
const validateRegistration = (user_name, email, password, confirm_password) => {
    const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;

    if (user_name === '') {
        return { isValid: false, message: "⚠️ Please enter the username!" };
    }

    if (email === '') {
        return { isValid: false, message: "⚠️ Please enter the Email!" };
    }
    else if (!emailRegex.test(email)) {
        return { isValid: false, message: "⚠️ Invalid email format!" };
    }

    if (password === '') {
        return { isValid: false, message: "⚠️ Please enter the password!" };
    }else if  (!passwordRegex.test(password)) {
        return { isValid: false, message: "⚠️ Password must be at least 8 characters long, contain an uppercase letter, a lowercase letter, a number, and a special character!" };
    }

    if (confirm_password !== password) {
        return { isValid: false, message: "⚠️ Confirm password does not match your entered password!" };
    }

    return { isValid: true, message: "Validation successful!" };
};


    function saveUser(e) {
        e.preventDefault();
        
        const validation = validateRegistration(user_name,email,password,confirm_password);
        
        if (!validation.isValid) {
            alert(validation.message)
            return false
        }

        const user = {user_name,email,password}
        addUser(user).then((response) => (
            console.log("Employee added: "+response)),
            setUserName(""),
            setpassword(""),
            setEmail(""),
            setConformPass("")
        ).catch((err)=> console.log("You got the error: "+err))
        document.getElementById('myForm').reset();
    }


  return (
    <div className="container">
    <h1>Create Your Account</h1>
    <p className="sub-heading">Join us to start editing your poetry</p>
    <form className="form" method='POST' id='myForm'>
        <div className="form-field">
            <label htmlFor="user_name">Username</label>
            <input type="text" id="user_name" value={user_name} onChange={(e)=> setUserName(e.target.value)} placeholder="Enter your username" required/>
        </div>

        <div className="form-field">
            <label htmlFor="email">Email</label>
            <input type="email" id="email" value={email} onChange={(e) =>setEmail(e.target.value)} placeholder="Enter your email" required/>
        </div>

        <div className="form-field">
            <label htmlFor="password">Password</label>
            <input type="password" id="password" onChange={(e) => setpassword(e.target.value)} name="password" placeholder="Create a password" required/>
            <div className="password-strength">
                <div className="strength weak"></div>
                <div className="strength medium"></div>
                <div className="strength strong"></div>
            </div>
        </div>

        <div className="form-field">
            <label htmlFor="confirm_password">Confirm Password</label>
            <input type="password" id="confirm_password" name="confirm_password" onChange={(e)=>setConformPass(e.target.value)} placeholder="Confirm your password" required/>
        </div>


        <button type="submit" className="submit-btn" onClick={saveUser}>Create Account</button>
    </form>

    <p className="login-link">Already have an account? <Link to={"/"}>Login</Link></p>
</div>
  )
}
