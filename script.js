const apiBaseUrl = window.location.hostname === 'localhost'
  ? 'http://localhost:8080/api'
  : 'https://api.example.com/api';
const contactForm = document.getElementById('contact-form');
const statusMessage = document.getElementById('form-status');

if (contactForm) {
  contactForm.addEventListener('submit', async (event) => {
    event.preventDefault();
    const formData = new FormData(contactForm);
    const payload = {
      name: formData.get('name')?.toString().trim() || '',
      email: formData.get('email')?.toString().trim() || '',
      message: formData.get('message')?.toString().trim() || ''
    };

    if (!payload.name || !payload.email || !payload.message) {
      statusMessage.textContent = 'すべての項目を入力してください。';
      statusMessage.className = 'error';
      return;
    }

    statusMessage.textContent = '送信中...';
    statusMessage.className = '';

    try {
      const response = await fetch(`${apiBaseUrl}/contact`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(payload)
      });

      if (!response.ok) {
        const errorText = await response.text();
        throw new Error(errorText || '送信に失敗しました');
      }

      statusMessage.textContent = '送信が完了しました。ありがとうございます！';
      contactForm.reset();
    } catch (error) {
      statusMessage.textContent = '送信に失敗しました。後ほど再度お試しください。';
      statusMessage.className = 'error';
      console.error('Contact submit failed', error);
    }
  });
}
