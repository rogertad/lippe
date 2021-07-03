package br.ufsc.lippe.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class PautaVideoDAO {
	
	public void addPauta(PautaVideo pauta) {
		Transaction trns = null;
		Session session = HiberUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(pauta);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	public void deletePauta(int id) {
		Transaction trns = null;
		Session session = HiberUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			PautaVideo pauta = (PautaVideo) session.load(PautaVideo.class, new Integer(id));
			session.delete(pauta);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	public void updatePauta(PautaVideo pauta) {
		Transaction trns = null;
		Session session = HiberUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(pauta);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	public List<PautaVideo> getAllPautas() {
		List<PautaVideo> pautas = new ArrayList<PautaVideo>();
		Transaction trns = null;
		Session session = HiberUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			pautas = session.createQuery("from PautaVideo").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return pautas;
	}

	public PautaVideo getPautaById(int id) {
		PautaVideo pauta = null;
		Transaction trns = null;
		Session session = HiberUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			String queryString = "from PautaVideo where id = :id";
			Query query = session.createQuery(queryString);
			query.setInteger("id", id);
			pauta = (PautaVideo) query.uniqueResult();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return pauta;
	}
}



