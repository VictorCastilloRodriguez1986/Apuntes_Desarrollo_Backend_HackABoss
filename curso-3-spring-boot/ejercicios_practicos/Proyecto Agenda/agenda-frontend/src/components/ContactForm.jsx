import { useState, useEffect } from 'react';
import { createContact, getContact, updateContact } from '../api';
import { useNavigate, useParams, Link } from 'react-router-dom';

export default function ContactForm() {
  const [contact, setContact] = useState({ name: '', email: '', phone: '' });
  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    if (id) {
      getContact(id).then(setContact);
    }
  }, [id]);

  const handleChange = (e) => {
    setContact({ ...contact, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (id) {
      await updateContact(id, contact);
    } else {
      await createContact(contact);
    }
    navigate('/');
  };

  return (
    <div className="min-h-screen bg-gray-900 py-10 px-4">
      <div className="max-w-sm mx-auto bg-neutral-900 p-6 rounded shadow-md text-white">
        <h2 className="text-2xl font-bold mb-6 text-center">
          {id ? '✏️ Editar contacto' : '➕ Nuevo contacto'}
        </h2>
        <form onSubmit={handleSubmit} className="space-y-6">
          <div>
            <label className="block text-sm font-medium mb-1 text-center">Nombre</label>
            <input
              name="name"
              value={contact.name}
              onChange={handleChange}
              placeholder="Ej. Juan Pérez"
              required
              className="p-2 w-[300px] mx-auto block border border-gray-600 rounded bg-gray-800 text-white placeholder-gray-400"
            />
          </div>
          <div>
            <label className="block text-sm font-medium mb-1 text-center">Email</label>
            <input
              name="email"
              type="email"
              value={contact.email}
              onChange={handleChange}
              placeholder="Ej. juan@example.com"
              required
              className="p-2 w-[300px] mx-auto block border border-gray-600 rounded bg-gray-800 text-white placeholder-gray-400"
            />
          </div>
          <div>
            <label className="block text-sm font-medium mb-1 text-center">Teléfono</label>
            <input
              name="phone"
              value={contact.phone}
              onChange={handleChange}
              placeholder="Ej. +34 600 123 456"
              required
              className="p-2 w-[300px] mx-auto block border border-gray-600 rounded bg-gray-800 text-white placeholder-gray-400"
            />
          </div>
          <div className="text-center">
            <button
                type="submit"
                className="bg-blue-600 text-white py-2 px-6 rounded hover:bg-blue-700 transition-colors"
            >
                {id ? '💾 Actualizar contacto' : '✅ Crear contacto'}
            </button>
            <Link
                to="/"
                className="block mt-4 bg-gray-700 text-white py-2 px-6 rounded hover:bg-gray-600 transition-colors text-center"
            >
                🔙 Volver
            </Link>
            </div>
        </form>
      </div>
    </div>
  );
}