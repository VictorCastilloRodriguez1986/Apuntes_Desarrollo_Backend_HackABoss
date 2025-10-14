const API_URL = 'http://localhost:8080/api/contactos';

export const getContacts = async () => {
  const res = await fetch(API_URL);
  return res.json();
};

export const getContact = async (id) => {
  const res = await fetch(`${API_URL}/${id}`);
  return res.json();
};

export const createContact = async (contact) => {
  await fetch(API_URL, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(contact),
  });
};

export const updateContact = async (id, contact) => {
  await fetch(`${API_URL}/${id}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(contact),
  });
};

export const deleteContact = async (id) => {
  await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
};