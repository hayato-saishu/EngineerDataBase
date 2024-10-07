import React, { useState } from 'react';
import { TextField, Button, Container, Grid } from '@mui/material';
import axios from 'axios';

const SearchForm: React.FC = () => {
    const [name, setName] = useState('');
    const [language, setLanguage] = useState('');
    const [yearsOfExperience, setYearsOfExperience] = useState<number | ''>('');

    const handleSearch = () => {
        if (!name && !language && !yearsOfExperience) {
            alert('いずれかの項目を入力してください');
            return;
        }
        // API呼び出しロジック
        axios.get("http://localhost:8080/api/engineer/search", {
            headers: {
                "Content-Type": "application/json"
            },
            params: {
                name: name,
                language: language,
                yearsOfExperience: yearsOfExperience
            }
        })
        .then((response) => {
            // eslint-disable-next-line @typescript-eslint/no-unused-vars
            const engineer = response.data;
            console.log(response.data);
        })
        .catch((error) => {
            alert("api取得に失敗しました" + error)
            return;
        })
    };

    return (
        <Container>
            <Grid container spacing={2} mt={4}>
                <Grid item xs={12} sm={4}>
                    <TextField
                        label="名前"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                        fullWidth
                    />
                </Grid>
                <Grid item xs={12} sm={4}>
                    <TextField
                        label="言語"
                        value={language}
                        onChange={(e) => setLanguage(e.target.value)}
                        fullWidth
                    />
                </Grid>
                <Grid item xs={12} sm={4}>
                    <TextField
                        label="経験年数"
                        type="number"
                        value={yearsOfExperience}
                        onChange={(e) => setYearsOfExperience(Number(e.target.value))}
                        fullWidth
                    />
                </Grid>
                <Grid item xs={12}>
                    <Button variant="contained" color="primary" onClick={handleSearch}>
                        検索
                    </Button>
                </Grid>
            </Grid>
        </Container>
    );
};

export default SearchForm;
