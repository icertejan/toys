package ro.certejan.springdatatransactions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.certejan.springdatatransactions.dao.BarDao;
import ro.certejan.springdatatransactions.model.Bar;

@Service
public class BarServiceImpl implements BarService {

	@Autowired
	private BarDao barDao;

	@Override
	@Transactional(transactionManager = "barTransactionManager")
	public void saveBars(Bar... bar) {
		for (Bar oneBar : bar) {
			barDao.save(oneBar);
		}
	}
}
