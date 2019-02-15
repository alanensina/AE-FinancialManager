package repository;

import java.util.List;

import model.User;

public interface UserRepository<G> {

	public boolean register(G obj);

	public boolean delete(G obj);

	public boolean update(G obj);

	public List<G> list();

	public boolean updateStatus(int id, boolean active);

	public int findID(String username);

	public User findUserByID(int id);

}
