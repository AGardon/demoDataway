package com.example.demodataway.hasor;

import net.hasor.core.ApiBinder;
import net.hasor.core.DimModule;
import net.hasor.db.JdbcModule;
import net.hasor.db.Level;
import net.hasor.spring.SpringModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author 王艺翔
 * @description Module
 * @date 2022/6/2 16:10
 * @phone 18318436514
 * @email g2603494062@gmail.com
 * @github https://github.com/AGarden
 */
@DimModule
@Component
public class Module implements SpringModule {
	@Autowired
	private DataSource dataSource = null;

	@Override
	public void loadModule(ApiBinder apiBinder) throws Throwable {

		// DataSource form Spring boot into Hasor
		apiBinder.installModule(new JdbcModule(Level.Full, this.dataSource));
	}
}
