package com.expensetracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensetracker.entity.Expense;
import com.expensetracker.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public Integer saveExpense(Expense expense) {
		return expenseRepository.save(expense).getEid();
	}

	@Override
	public Expense findById(Integer eid) {
		return expenseRepository.findById(eid).get();
	}

	@Override
	public String updateExpense(Expense expense) {
		Expense oldExpense = findById(expense.getEid());
		oldExpense.setName(expense.getName());
		oldExpense.setDescription(expense.getDescription());
		oldExpense.setAmount(expense.getAmount());
		expenseRepository.save(oldExpense);
		return "Expense updated successfully!";
	}

	@Override
	public String deleteExpense(Integer eid) {
		expenseRepository.deleteById(eid);
		return "Expense deleted successfully!";
	}
}
