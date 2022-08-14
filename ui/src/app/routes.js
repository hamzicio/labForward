// packages
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { NotFound404Page, SearchPage } from "../pages";

// pages

export const Routing = () => {
  return (
    <Router>
      <Routes>
        <Route index element={<SearchPage />} />
        <Route path="*" element={<NotFound404Page />} />
      </Routes>
    </Router>
  );
};
