package in.ineuron.idgenerator;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.SimpleFormatter;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyGeneratorDate implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor si, Object obj) throws HibernateException {
		String date = new SimpleDateFormat("yyyy-mm-dd").format(new Date());
		int num = new Random().nextInt(1000);
		String prefix1 = "Nand-";
		String prefix2 = "HB-";
		return prefix1 + date + prefix2 + num; 
	}

}
