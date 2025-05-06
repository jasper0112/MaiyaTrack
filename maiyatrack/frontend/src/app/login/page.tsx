'use client'
import { useState } from 'react';
import { IconInfoCircle } from '@tabler/icons-react';
import { Center, PasswordInput, Text, TextInput, Tooltip } from '@mantine/core';
import classes from "./login.module.css"


function TooltipIcon() {
    const rightSection = (
      <Tooltip
        label="We store your data securely"
        position="top-end"
        withArrow
        transitionProps={{ transition: 'pop-bottom-right' }}
      >
        <Text component="div" c="dimmed" style={{ cursor: 'help' }}>
          <Center>
            <IconInfoCircle size={18} stroke={1.5} />
          </Center>
        </Text>
      </Tooltip>
    );
  
    return (
      <TextInput
        rightSection={rightSection}
        label="Tooltip shown on icon hover"
        placeholder="Your email"
      />
    );
  }
  
function TooltipFocus() {
  const [opened, setOpened] = useState(false);
  const [value, setValue] = useState('');
  const valid = value.trim().length >= 6;
  return (
    <Tooltip
      label={valid ? 'All good!' : 'Password must include at least 6 characters'}
      position="bottom-start"
      withArrow
      opened={opened}
      color={valid ? 'teal' : undefined}
      withinPortal
    >
      <PasswordInput
        label="Tooltip shown onFocus"
        required
        placeholder="Your password"
        onFocus={() => setOpened(true)}
        onBlur={() => setOpened(false)}
        mt="md"
        value={value}
        onChange={(event) => setValue(event.currentTarget.value)}
      />
    </Tooltip>
  );
}
  

export default function LoginPage() {

  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')

  const handleLogin = async (e: React.FormEvent) => {
    e.preventDefault()
    // TODO: 调用后端登录API
    alert(`Logging in with ${email} / ${password}`)
  }

  return (
    <div className='login_page'>
      <form onSubmit={handleLogin} className={classes.login_form}>
        <TooltipIcon />
        <TooltipFocus />
        <button type="submit" className='login_button'>
          Login
        </button>
      </form>
    </div>
  );
  
}





