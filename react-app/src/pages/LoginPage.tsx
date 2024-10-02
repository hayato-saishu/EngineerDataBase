import React, { useState } from 'react';
import { Container, TextField, Button, Typography, Box } from '@mui/material';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const LoginPage: React.FC = () => {
  const [email, setEmail] = useState<string>('');
  const [password, setPassword] = useState<string>('');
  const navigate = useNavigate();

  const handleLogin = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
        await axios.post('/login', { email, password });
        navigate('/engineer/search'); // ログイン成功後のリダイレクト先
    } catch (error) {
        console.error('Login failed', error);
    }
      // e.preventDefault();
      // try {
      //   axios.get('http://localhost:8080/api/user/login', {
      //     headers: {
      //         "Content-Type": 'application/json'
      //     },
      //     params: {
      //         emailAddress: email,
      //         password: password
      //     }
      // })
      // .then(response => {
      //     const count = response.data.count;
      //     if(count === 0){
      //         alert('ユーザーが見つかりません');
      //     }
      //     navigate('engineer/search');
      // })
      // } catch (error) {
      //     console.error('Login failed', error);
      // }
  };

  return (
    <Container maxWidth="sm">
      <Box sx={{ mt: 8, display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
        <Typography component="h1" variant="h5">
          ログイン
        </Typography>
        <Box component="form" sx={{ mt: 1 }}>
          <TextField
            margin="normal"
            required
            fullWidth
            id="email"
            label="メールアドレス"
            name="email"
            autoComplete="email"
            autoFocus
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          <TextField
            margin="normal"
            required
            fullWidth
            name="password"
            label="パスワード"
            type="password"
            id="password"
            autoComplete="current-password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <Button
            type="button"
            fullWidth
            variant="contained"
            sx={{ mt: 3, mb: 2 }}
            onClick={handleLogin}
          >
            ログイン
          </Button>
        </Box>
      </Box>
    </Container>
  );
};

export default LoginPage;
