import React, { useEffect, useState } from 'react';
import axios from 'axios';

function BudgetPage() {
  const [budgets, setBudgets] = useState([]);
  const [newBudget, setNewBudget] = useState({ amount: '', category: '' });

  useEffect(() => {
    // Fetch budgets from the backend
    axios.get('/api/budgets')
      .then(response => setBudgets(response.data))
      .catch(error => console.error('Error fetching budgets:', error));
  }, []);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewBudget({ ...newBudget, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post('/api/budgets', newBudget)
      .then(response => setBudgets([...budgets, response.data]))
      .catch(error => console.error('Error adding budget:', error));
  };

  return (
    <div>
      <h1>Budgets</h1>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="category"
          value={newBudget.category}
          onChange={handleInputChange}
          placeholder="Category"
          required
        />
        <input
          type="number"
          name="amount"
          value={newBudget.amount}
          onChange={handleInputChange}
          placeholder="Amount"
          required
        />
        <button type="submit">Add Budget</button>
      </form>

      <ul>
        {budgets.map((budget) => (
          <li key={budget.id}>
            {budget.category}: ${budget.amount}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BudgetPage;
