import React from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import EngineerSearchPage from './pages/EngineerSearchPage/EngineerSearchPage';
import EngineerDetailPage from './pages/EngineerDetailPage/EngineerDetailPage';

const App: React.FC = () => {
  return (
    <Router>
      <Routes>
        <Route path="/loginPage" element={<LoginPage />} />
        <Route path="/" element={<Navigate to="/loginPage" />} />
        <Route path="/engineer/Search" element={<EngineerSearchPage results={[]} />} />
        <Route path="/engineer/Detail" element={<EngineerDetailPage />} />
      </Routes>
    </Router>
  );
}

export default App;
