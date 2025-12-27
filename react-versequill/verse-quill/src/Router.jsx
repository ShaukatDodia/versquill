import { createBrowserRouter } from "react-router-dom";
import { LoginPage } from "./components/LoginPage";
import { RegistrationPage } from "./components/RegistrationPage";


const router = createBrowserRouter([
    {
      path: "/registration",
      element: <RegistrationPage />,
    },
    {
      path: "/",
      element: <LoginPage />,
    },
  ]);
  
  export default router;