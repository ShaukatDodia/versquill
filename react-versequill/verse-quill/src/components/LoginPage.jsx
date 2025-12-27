import React from 'react';
import '../assets/style/LoginPage.css'
import { Link } from 'react-router-dom';

export const LoginPage = () => {
  return (
    <div className="login-container">
      <div className="login-card">
        <h2 className="login-heading">Login to Your Account</h2>

        <form className="login-form">
          <div className="form-field">
            <label htmlFor="email">Email Address</label>
            <input type="email" id="email" placeholder="Enter your email" required />
          </div>

          <div className="form-field">
            <label htmlFor="password">Password</label>
            <input type="password" id="password" placeholder="Enter your password" required />
          </div>

          <button type="submit" className="login-button">
            Log In
          </button>

          <div className="forgot-password">
            <p>Forgot password?</p>
          </div>

          <div className="signup-link">
            <p>Don't have an account? <Link to="/registration">Sign Up</Link></p>
          </div>
        </form>
      </div>
    </div>
  )
}
