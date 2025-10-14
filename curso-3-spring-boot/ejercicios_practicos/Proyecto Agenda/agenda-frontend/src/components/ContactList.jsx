import { useEffect, useState } from 'react';
import { getContacts, deleteContact } from '../api';
import { useNavigate } from 'react-router-dom';

export default function ContactList() {
  const [contacts, setContacts] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    getContacts().then(setContacts);
  }, []);

  const handleDelete = async (id) => {
    await deleteContact(id);
    setContacts(contacts.filter(c => c.id !== id));
  };

  const handleEdit = (id) => {
    navigate(`/edit/${id}`);
  };

  return (
    <div className="min-h-screen bg-gray-100 py-10 px-4">
      <div className="bg-white p-6 rounded shadow-md w-full max-w-3xl mx-auto">
        <h1 className="text-2xl font-bold mb-6 text-center text-gray-800">📒 Agenda de Contactos</h1>

        {contacts.length === 0 ? (
          <p className="text-center text-gray-500 mb-6">No hay contactos aún.</p>
        ) : (
          <ul className="space-y-4 mb-6">
            {contacts.map(c => (
              <li key={c.id} className="flex justify-between items-center bg-gray-50 p-4 rounded shadow-sm">
                <div>
                  <p className="text-lg font-semibold text-gray-900">{c.name}</p>
                  <p className="text-sm text-gray-600">{c.email} | {c.phone}</p>
                </div>
                <div className="flex space-x-2">
                  <button
                    onClick={() => handleEdit(c.id)}
                    className="bg-blue-600 text-white px-3 py-1 rounded hover:bg-blue-700 transition"
                  >
                    ✏️ Editar
                  </button>
                  <button
                    onClick={() => handleDelete(c.id)}
                    className="bg-red-600 text-white px-3 py-1 rounded hover:bg-red-700 transition"
                  >
                    🗑️ Eliminar
                  </button>
                </div>
              </li>
            ))}
          </ul>
        )}

        <div className="text-center space-y-4">
          <button
            onClick={() => navigate('/new')}
            className="inline-block bg-green-600 text-white py-2 px-4 rounded hover:bg-green-700 transition"
          >
            ➕ Nuevo contacto
          </button>

          <button
            onClick={() => navigate('/buscar')}
            className="inline-block bg-indigo-600 text-white py-2 px-4 rounded hover:bg-indigo-700 transition"
          >
            🔍 Buscar por ID
          </button>
        </div>
      </div>
    </div>
  );
}