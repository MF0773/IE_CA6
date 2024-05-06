import MainView from "Frontend/views/MainView.js";
import CustomerView from "Frontend/views/CustomerView.js";

import { createBrowserRouter, RouteObject } from "react-router-dom";
import ResturantsView from "./views/RestaurantsView";
import AuthenticationView from "Frontend/views/AuthenticationView";

export const routes: readonly RouteObject[] = [
  { path: "/", element: <MainView /> },
  { path: "/home", element: <CustomerView /> },
  { path: "/restaurants_page", element: <ResturantsView /> },
  { path: "/auth", element: <AuthenticationView />},
];

export const router = createBrowserRouter([...routes], {
  basename: new URL(document.baseURI).pathname,
});
