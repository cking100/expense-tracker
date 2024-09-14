import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ExpensePage from './pages/ExpensePage';
import InvestmentPage from './pages/InvestmentPage';

const App = () => {
  return (
    <Router>
      <div>
        <h1>Welcome to the Expense Tracker</h1>
        <Routes>
          <Route path="/expenses" element={<ExpensePage />} />
          <Route path="/investments" element={<InvestmentPage />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
