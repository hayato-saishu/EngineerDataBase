import React, { useState } from 'react';
import { TextField, Button, Container, Grid } from '@mui/material';

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
    };

    return (
        <Container>
            <Grid container spacing={2}>
                <Grid item xs={12} sm={4}>
                    <TextField
                        label="Name"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                        fullWidth
                    />
                </Grid>
                <Grid item xs={12} sm={4}>
                    <TextField
                        label="Language"
                        value={language}
                        onChange={(e) => setLanguage(e.target.value)}
                        fullWidth
                    />
                </Grid>
                <Grid item xs={12} sm={4}>
                    <TextField
                        label="Years of Experience"
                        type="number"
                        value={yearsOfExperience}
                        onChange={(e) => setYearsOfExperience(Number(e.target.value))}
                        fullWidth
                    />
                </Grid>
                <Grid item xs={12}>
                    <Button variant="contained" color="primary" onClick={handleSearch}>
                        Search
                    </Button>
                </Grid>
            </Grid>
        </Container>
    );
};

export default SearchForm;
