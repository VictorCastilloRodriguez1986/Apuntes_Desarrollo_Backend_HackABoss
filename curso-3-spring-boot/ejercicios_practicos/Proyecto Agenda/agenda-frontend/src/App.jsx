import { BrowserRouter, Routes, Route } from 'react-router-dom';
import ContactList from './components/ContactList';
import ContactForm from './components/ContactForm';
import BuscarContacto from './components/BuscarContacto';

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<ContactList />} />
        <Route path="/new" element={<ContactForm />} />
        <Route path="/edit/:id" element={<ContactForm />} />
        <Route path="/buscar" element={<BuscarContacto />} />
      </Routes>
    </BrowserRouter>
  );
}